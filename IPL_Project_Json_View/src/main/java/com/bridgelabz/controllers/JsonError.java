package com.bridgelabz.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.google.common.collect.ImmutableMap;

@SuppressWarnings("deprecation")
public class JsonError {
	    private final String message;

	    public JsonError(String message) {
	        this.message = message;
	    }
	    public ModelAndView asModelAndView() {
	        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
	        return new ModelAndView(jsonView, ImmutableMap.of("error", message));
	    }
}
