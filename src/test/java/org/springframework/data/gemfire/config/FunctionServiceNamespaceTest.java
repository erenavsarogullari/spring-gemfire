/*
 * Copyright 2010-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.gemfire.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.data.gemfire.RecreatingContextTest;

import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionService;

/**
 * @author Costin Leau
 */
public class FunctionServiceNamespaceTest extends RecreatingContextTest {

	@Override
	protected String location() {
		return "org/springframework/data/gemfire/config/function-service-ns.xml";
	}

	@Test
	public void testFunctionsRegistered() throws Exception {
		assertEquals(2, FunctionService.getRegisteredFunctions().size());
		assertNotNull(FunctionService.getFunction("function1"));
		assertNotNull(FunctionService.getFunction("function2"));
	}

	@SuppressWarnings("serial")
	public static class Function1 extends FunctionAdapter {

		@Override
		public void execute(FunctionContext arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getId() {
			return "function1";
		}

	}

	@SuppressWarnings("serial")
	public static class Function2 extends FunctionAdapter {

		@Override
		public void execute(FunctionContext arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getId() {
			return "function2";
		}

	}
}