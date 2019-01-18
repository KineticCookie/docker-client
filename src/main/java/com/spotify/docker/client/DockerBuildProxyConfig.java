/*-
 * -\-\-
 * docker-client
 * --
 * Copyright (C) 2018 Spotify AB
 * Copyright (C) 2018 Bulat Lutfullin
 * --
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
 * -/-/-
 */

package com.spotify.docker.client;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;


/**
 * Represents the contents of proxies field in config.json
 */
@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class DockerBuildProxyConfig {
  @Nullable
  @JsonProperty("httpProxy")
  public abstract String httpProxy();
  
  @Nullable
  @JsonProperty("httpsProxy")
  public abstract String httpsProxy();
  
  @Nullable
  @JsonProperty("ftpProxy")
  public abstract String ftpProxy();
  
  @Nullable
  @JsonProperty("noProxy")
  public abstract String noProxy();
  
  @JsonCreator
  public static DockerBuildProxyConfig create(
          @JsonProperty("httpProxy") final String httpProxy,
          @JsonProperty("httpsProxy") final String httpsProxy,
          @JsonProperty("ftpProxy") final String ftpProxy,
          @JsonProperty("noProxy") final String noProxy) {
    return new AutoValue_DockerBuildProxyConfig(
            httpProxy,
            httpsProxy,
            ftpProxy,
            noProxy
    );
  }
}
