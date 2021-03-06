/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.integration.dsl.groovy.builder

import static org.junit.Assert.*
import org.junit.Test
/**
 * @author David Turanski
 *
 */
class SimpleTransformerTests {
	IntegrationBuilder builder = new IntegrationBuilder()

	@Test
	void testTransformer() {
		def flow = builder.messageFlow {
			transform('myTransformer',{it.toUpperCase()})
		}

		def result = flow.sendAndReceive('hello')
		assert result == 'HELLO'
	}
}
