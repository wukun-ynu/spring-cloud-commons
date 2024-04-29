/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.springframework.cloud.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration to import the {@link BootstrapImportSelector} configuration.
 *
 * @author Spencer Gibb
 */
/**
 * BootstrapImportSelectorConfiguration 会通过 @Import 导入 {@link BootstrapImportSelector}
 * 其回调方法 {@link BootstrapImportSelector#selectImports(AnnotationMetadata)} 的逻辑是
 *  1. 读取 META-INF/spring.factories 获取key为BootstrapConfiguration的值
 *  2. 获取属性 spring.cloud.bootstrap.sources 的值
 *  3. 合并第一第二的值，然后排序
 *  4. 会将值注册到容器中,作为容器的配置类
 *
 * 而
 * spring-cloud-context.jar!/META-INF/spring.factories 中定义了
 *  org.springframework.cloud.bootstrap.BootstrapConfiguration = org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration
 *
 * 也就是 {@link PropertySourceBootstrapConfiguration} 会注册到 bootstrapContext 中，
 * 它是 ApplicationContextInitializer 类型的，最终会用来初始化 context
 * */
@Configuration(proxyBeanMethods = false)
@Import(BootstrapImportSelector.class)
public class BootstrapImportSelectorConfiguration {

}
