package com.dib.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.dib.command.PersonCommand;

@Component
public class Validator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) 
	{
		return clazz.isAssignableFrom(PersonCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) 
	{
		PersonCommand cmd=null;
		cmd=(PersonCommand) target;
		
		if(cmd.getAge()<0 || cmd.getAge()>100)
		{
			errors.rejectValue("age", "perCmd.age,range");
		}
		if(cmd.getHobies().length==0 || cmd.getHobies()==null)
		{
			errors.rejectValue("age", "perCmd.hobies,required");
		}
	}

}
