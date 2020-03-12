package com.hari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hk.dojo.Name;
import com.hk.dojo.StudentV1;
import com.hk.dojo.StudentV2;

@RestController
public class StudentVersioningController {

	@RequestMapping(value = "v1/student", method = RequestMethod.GET)
	public StudentV1 studentV1() {
		return new StudentV1("Bob Charlie");
	}

	@RequestMapping(value = "v2/student", method = RequestMethod.GET)
	public StudentV2 studentV2() {
		return new StudentV2(new Name("Bob", "Charlie"));
	}

	@RequestMapping(value = "/student/param", params = "version=1", method = RequestMethod.GET)
	public StudentV1 paramV1() {
		return new StudentV1("Bob Charlie");
	}

	@RequestMapping(value = "/student/param", params = "version=2", method = RequestMethod.GET)
	public StudentV2 paramV2() {
		return new StudentV2(new Name("Bob", "Charlie"));
	}

	@RequestMapping(value = "/student/header", headers = "X-API-VERSION=1", method = RequestMethod.GET)
	public StudentV1 headerV1() {
		return new StudentV1("Bob Charlie");
	}

	@RequestMapping(value = "/student/header", headers = "X-API-VERSION=2", method = RequestMethod.GET)
	public StudentV2 headerV2() {
		return new StudentV2(new Name("Bob", "Charlie"));
	}

	@RequestMapping(value = "/student/produces", produces = "application/vnd.company.app-v1+json", method = RequestMethod.GET)
	public StudentV1 producesV1() {
		return new StudentV1("Bob Charlie");
	}

	@RequestMapping(value = "/student/produces", produces = "application/vnd.company.app-v2+json", method = RequestMethod.GET)
	public StudentV2 producesV2() {
		return new StudentV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(value = "/student/produces2", produces = "application/vnd.hk.app-v2+json")
	public StudentV2 producesV21() {
		return new StudentV2(new Name("Hari", "Kiran"));
	}

}
