package com.apress.practicalvaadin.ch05;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class StringToCodeConverter implements Converter<String, Code> {

  @Override
  public Result<Code> convertToModel(String value, ValueContext context) {
    for (Type t : Type.values()) {
      if (value.startsWith(t.toString())) {
        Code code = new Code(t, value.substring(t.toString().length()));
        return Result.ok(code);
      }
    }

    return Result.error("Error parsing the code");
  }

  @Override
  public String convertToPresentation(Code code, ValueContext context) {
    return code.getType().toString() + code.getNumber();
  }

}
