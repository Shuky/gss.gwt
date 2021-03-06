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

package com.google.gwt.resources.gss.ast;

import com.google.common.css.compiler.ast.CssValueNode;

public class CssJavaExpressionNode extends CssValueNode {

  public CssJavaExpressionNode(String expression) {
    super(expression);
  }

  @Override
  public CssValueNode deepCopy() {
    return new CssJavaExpressionNode(getValue());
  }

  @Override
  public String toString() {
    return "Java expression : " + getValue();
  }
}
