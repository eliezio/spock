/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.spockframework.util

import spock.lang.Specification

class ExceptionUtilSpec extends Specification {
  def "print stack trace to string"() {
    def exception = new IOException("ouch")
    def elem = new StackTraceElement("DeclaringClass", "methodName", "filename", 42)
    exception.stackTrace = [elem]

    expect:
    ExceptionUtil.printStackTrace(exception) == "java.io.IOException: ouch\n\tat DeclaringClass.methodName(filename:42)\n"
  }
}
