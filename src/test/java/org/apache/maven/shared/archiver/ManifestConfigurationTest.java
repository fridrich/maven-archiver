/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.shared.archiver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManifestConfigurationTest {

    private ManifestConfiguration manifestConfiguration;

    @BeforeEach
    void before() {
        this.manifestConfiguration = new ManifestConfiguration();
    }

    @Test
    void classpathLayoutTypeSimple() {
        assertThat(manifestConfiguration.getClasspathLayoutType())
                .isEqualTo(ManifestConfiguration.CLASSPATH_LAYOUT_TYPE_SIMPLE);
    }

    @Test
    void getClasspathPrefixShouldReturnPrefixWithSlashesInsteadOfBackSlashes() {
        manifestConfiguration.setClasspathPrefix("\\lib\\const\\");
        assertThat(manifestConfiguration.getClasspathPrefix()).isEqualTo("/lib/const/");
    }

    @Test
    void getClasspathPrefixShouldReturnPrefixWithTraingSlash() {
        manifestConfiguration.setClasspathPrefix("const");
        assertThat(manifestConfiguration.getClasspathPrefix()).isEqualTo("const/");
    }

    @Test
    void getClasspathPrefixShouldReturnTheTrailingSlash() {
        manifestConfiguration.setClasspathPrefix("const/");
        assertThat(manifestConfiguration.getClasspathPrefix()).isEqualTo("const/");
    }
}
