package com.biblioteca.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.biblioteca.Entity.prestamos;
import com.biblioteca.Repository.estadolibroRepository;
import com.biblioteca.Repository.librosRepository;
import com.biblioteca.Repository.usuarioRepository;
import com.biblioteca.Service.prestamoService;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class prestamosController {

	@Autowired
	private prestamoService prestamoService;
	
	@Autowired
	private usuarioRepository usuarioRepository;
	
	@Autowired
	private librosRepository librosRepository;
	
	@Autowired
	private estadolibroRepository estadolibroRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@GetMapping("/RegistroPrestamos-list")
	public String listPrestamo(Model model) {
		
		List<prestamos> prestamosList = prestamoService.getAll();
		model.addAttribute("prestamosList", prestamosList);
		
		for(prestamos prestamos: prestamosList) {
			System.out.println(prestamos.getUsuario());
			System.out.println(prestamos.getLibros());
			System.out.println(prestamos.getFecha_prestamo());
			System.out.println(prestamos.getFecha_devolucion());
			System.out.println(prestamos.getFecha_real());
			System.out.println(prestamos.getMulta());
			System.out.println(prestamos.getEstadoLibro());
			System.out.println(prestamos.getComentarios());
		}
		
		return "RegistroPrestamos-list";
	}
	
	
	@GetMapping("/new-prestamos")
	public String showNuevoPrestamo(Model model) {
		model.addAttribute("prestamos", new prestamos());
		model.addAttribute("type", "N");
		
		model.addAttribute("listaUsuario", usuarioRepository.findAll());
		model.addAttribute("listaLibros", librosRepository.findAll());
		model.addAttribute("listaEstadoLibro", estadolibroRepository.findAll());
		return "prestamos";
	}
	
	@GetMapping("/edit-prestamos/{id}")
	public String showEditPrestamos(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("prestamos", prestamoService.getPrestamos(id));
			model.addAttribute("type", "E");
			model.addAttribute("listaUsuario", usuarioRepository.findAll());
			model.addAttribute("listaLibros", librosRepository.findAll());
			model.addAttribute("listaEstadoLibro", estadolibroRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "prestamos";
	}
	
	@GetMapping("/remove-prestamos/{id}")
	public String removePrestamos(@PathVariable Integer id, Model model) {
		prestamoService.eliminar(id);
	
		return "redirect:/RegistroPrestamos-list";
	}
	
	
	@GetMapping("/view-prestamos/{id}")
	public String showViewPrestamos(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("prestamos", prestamoService.getPrestamos(id));
			model.addAttribute("type", "V");
			model.addAttribute("listaUsuario", usuarioRepository.findAll());
			model.addAttribute("listaLibros", librosRepository.findAll());
			model.addAttribute("listaEstadoLibro", estadolibroRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "prestamos";
	}
	
	
	@GetMapping("/viewMas-prestamos/{id}")
	public String showViewMasPrestamos(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("prestamos", prestamoService.getPrestamos(id));
			model.addAttribute("type", "V");
			model.addAttribute("listaUsuario", usuarioRepository.findAll());
			model.addAttribute("listaLibros", librosRepository.findAll());
			model.addAttribute("listaEstadoLibro", estadolibroRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detallePrestamo";
	}
	
	@PostMapping("/save-new-prestamos")
	public String saveNewPrestamos(@ModelAttribute prestamos prestamos, RedirectAttributes redirect) {
		try {
			prestamoService.crear(prestamos);
			redirect.addFlashAttribute("mensaje", "Préstamo creado correctamente.");
		} catch (Exception e) {
			redirect.addFlashAttribute("error", e.getMessage());
			return "redirect:/new-prestamos";
		}
		return "redirect:/RegistroPrestamos-list";
	}
	
	@PostMapping("/save-edit-prestamos")
	public String saveEditPrestamos(@ModelAttribute prestamos prestamos, RedirectAttributes redirect) {
		try {
			prestamoService.crear(prestamos);
			redirect.addFlashAttribute("mensaje", "Préstamo Editado correctamente.");
		} catch (Exception e) {
			redirect.addFlashAttribute("error", e.getMessage());
			return "redirect:/new-prestamos";
		}
		return "redirect:/RegistroPrestamos-list";
	}
	
	
	@GetMapping("/prestamo-reports/{id}")
	@ResponseBody
	public void exportarPrestamoIndividual(@PathVariable("id") Integer id, HttpServletResponse response) throws SQLException, JRException, IOException {
	    Connection cnx = jdbcTemplate.getDataSource().getConnection();

	    InputStream jasperStream = this.getClass().getResourceAsStream("/reports/verMasDetalle.jasper");
	    Map<String, Object> params = new HashMap<>();
	    params.put("id_prestamos", id);

	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, cnx);

	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=detalle_prestamo_" + id + ".pdf");

	    final OutputStream outputStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

	    cnx.close();
	}
	
	
}
