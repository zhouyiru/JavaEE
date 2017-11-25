package org.fkit.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormNameController {

	/*¶¯Ì¬Ìø×ªÒ³Ãæ*/
	@RequestMapping(value="/{formname}")
	public String formName(@PathVariable("formname") String formname)
	{
		return formname;
	}
}
