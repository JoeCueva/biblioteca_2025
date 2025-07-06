package com.biblioteca.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biblioteca.Entity.libros;
import com.biblioteca.Repository.estadolibroRepository;
import com.biblioteca.Service.autoresService;
import com.biblioteca.Service.categoriaService;
import com.biblioteca.Service.librosService;
import com.biblioteca.dao.LibroFilter;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


@Controller
public class libroController {

	@Autowired
	private librosService librosService;
	
	@Autowired
	private autoresService autoresService;
	
	@Autowired
	private categoriaService categoriaService;
	
	@Autowired
	private com.biblioteca.Repository.autoresRepository autoresRepository;

	@Autowired
	private com.biblioteca.Repository.categoriaRepository categoriaRepository;

	@Autowired
	private estadolibroRepository estadoLibroRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@GetMapping("/RegistroLibros-list")
	public String filtrado(@ModelAttribute LibroFilter filtro, Model model) {
		List<libros> libroList = librosService.search(filtro);
		
		model.addAttribute("listaAutores",autoresService.getAll());
		model.addAttribute("listaCategorias", categoriaService.getAll());
		model.addAttribute("filtro", filtro);
		model.addAttribute("libroList", libroList); 
		
		return ("RegistroLibros-list");
	}
	
	
	@GetMapping("/new-libros")
	public String showNuevoLibro(Model model) {
		model.addAttribute("libros", new libros());
		model.addAttribute("type", "N");

		model.addAttribute("listaAutores", autoresRepository.findAll());
		model.addAttribute("listaCategorias", categoriaRepository.findAll());
		model.addAttribute("listaEstados", estadoLibroRepository.findAll());

		return "libros";
	}
	
	@GetMapping("/edit-libros/{id}")
	public String showEditLibros(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("libros", librosService.getLibros(id));
			model.addAttribute("type", "E");

			model.addAttribute("listaAutores", autoresRepository.findAll());
			model.addAttribute("listaCategorias", categoriaRepository.findAll());
			model.addAttribute("listaEstados", estadoLibroRepository.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "libros";
	}
	
	@GetMapping("/remove-libros/{id}")
	public String removeLibros(@PathVariable Integer id, Model model) {
		librosService.eliminar(id);
	
		return "redirect:/RegistroLibros-list";
	}
	
	@GetMapping("/view-libros/{id}")
	public String showViewlibros(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("libros", librosService.getLibros(id));
			model.addAttribute("type", "V");
			model.addAttribute("listaAutores", autoresRepository.findAll());
			model.addAttribute("listaCategorias", categoriaRepository.findAll());
			model.addAttribute("listaEstados", estadoLibroRepository.findAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "libros";
	}
	
	@PostMapping("/save-new-libros")
	public String saveNewLibros(@ModelAttribute libros libros ) {
		try {
			librosService.crear(libros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroLibros-list";
	}
	
	@PostMapping("/save-edit-libros")
	public String saveEditLibros(@ModelAttribute libros libros) {
		try {
			librosService.editar(libros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/RegistroLibros-list";
	}
	
	
	@GetMapping("/libro-reports")
	@ResponseBody
	public void libroReport(HttpServletResponse response) throws SQLException, JRException, IOException {
		Connection cnx = jdbcTemplate.getDataSource().getConnection();
		
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/Libros.jasper");
		Map<String, Object> params = new HashMap<>(); 
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,cnx);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=libro_reports.pdf");
		
		final OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		cnx.close();
		
	}
	
	
	
	
	
}
