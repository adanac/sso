/**
 * Copyright (c) 2011-2014, adanac (1320643091@qq.com).
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
package com.github.adanac.framework.sso.waf;

import com.github.adanac.framework.sso.waf.attack.SqlInjection;
import com.github.adanac.framework.sso.waf.attack.XSS;

/**
 * Web防火墙工具类
 * <p>
 * @author   adanac
 * @Date	 2014-5-8 	 
 */
public class WafHelper {

	/**
	 * @Description 过滤XSS脚本内容
	 * @param value
	 * 				待处理内容
	 * @return
	 */
	public static String stripXSS(String value) {
		if (value == null) {
			return null;
		}

		return XSS.strip(value);
	}

	/**
	 * @Description 过滤SQL注入内容
	 * @param value
	 * 				待处理内容
	 * @return
	 */
	public static String stripSqlInjection(String value) {
		if (value == null) {
			return null;
		}

		return SqlInjection.strip(value);
	}

	/**
	 * @Description 过滤SQL/XSS注入内容
	 * @param value
	 * 				待处理内容
	 * @return
	 */
	public static String stripSqlXSS(String value) {
		if (value == null) {
			return null;
		}

		return XSS.strip(SqlInjection.strip(value));
	}

}
