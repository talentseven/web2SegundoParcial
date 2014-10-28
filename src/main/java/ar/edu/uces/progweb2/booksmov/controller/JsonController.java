package ar.edu.uces.progweb2.booksmov.controller;

import org.springframework.stereotype.Controller;

@Controller
public class JsonController {
	/*
	private SomethingDao somethingDao;

	@Autowired
	public void setSomethingDao(SomethingDao somethingDao) {
		this.somethingDao = somethingDao;
	}

	@RequestMapping(value = "/get/{id}")
	public @ResponseBody
	Map<String, Something> get(@PathVariable long id) {
		System.out.println("Get Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		return out;
	}

	@RequestMapping(value = "/find")
	public @ResponseBody
	Map<String, Something> find(@RequestParam("id") long id) {
		System.out.println("Find Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		return out;
	}
	
	@RequestMapping(value = "/find2")
	public @ResponseBody
	String find2(@RequestParam("id") long id) {
		System.out.println("Find Something with id " + id);
		Map<String, Something> out = new HashMap<String, Something>();
		out.put("something", somethingDao.get(id));
		//return out;
		return "/views/test.jsp";
	}
	*/
}
