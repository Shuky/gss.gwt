/*
 * Copyright 2013 Julien Dramaix.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package com.google.gwt.resources.gss;

import com.google.common.collect.ImmutableList;
import com.google.common.css.compiler.ast.CssValueNode;
import com.google.common.css.compiler.ast.ErrorManager;
import com.google.common.css.compiler.ast.GssFunction;
import com.google.common.css.compiler.ast.GssFunctionException;
import com.google.gwt.resources.gss.ast.CssDotPathNode;

import java.util.List;

public class ValueFunction implements GssFunction {
  public static String getName() {
    return "value";
  }

  @Override
  public List<CssValueNode> getCallResultNodes(List<CssValueNode> args, ErrorManager errorManager)
      throws GssFunctionException {
    if (args.size() == 0 || args.size() > 3) {
      throw new GssFunctionException(getName() + " function take one, two or three arguments");
    }

    String functionPath = args.get(0).getValue();
    String prefix = null;
    String suffix = null;

    if (args.size() > 1) {
      suffix = args.get(1).getValue();
    }

    if (args.size() > 2) {
      prefix = args.get(2).getValue();
    }

    CssDotPathNode cssDotPathNode = new CssDotPathNode(functionPath, prefix, suffix);

    // TODO add validation : maybe add a compilation pass that will validate the the method exist
    // on the resource bundle

    return ImmutableList.of((CssValueNode) cssDotPathNode);
  }

  @Override
  public String getCallResultString(List<String> args) throws GssFunctionException {

    String functionPath = args.get(0);
    String prefix = null;
    String suffix = null;

    if (args.size() > 1) {
      suffix = args.get(1);
    }

    if (args.size() > 2) {
      prefix = args.get(2);
    }

    return CssDotPathNode.resolveExpression(functionPath, prefix, suffix);
  }

  @Override
  public Integer getNumExpectedArguments() {
    // number of arguments is variable
    return null;
  }
}

