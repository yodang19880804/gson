/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson;

import com.google.gson.reflect.TypeToken;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/**
 * @author Jesse Wilson
 * 
 * 反序列化字符串可以添加注释（在某种情况下可能会有帮助）
 */
public final class CommentsTest extends TestCase {

  /**
   * Test for issue 212.
   * 
   */
  public void testParseComments() {
    String json = "[\n"
        + "  // this is a comment\n"
        + "  \"a\",\n"
        + "  /* this is another comment */\n"
        + "  \"b\",\n"
        + "  # this is yet another comment\n"
        + "  \"c\"\n"
        + "]";

    List<String> abc = new Gson().fromJson(json, new TypeToken<List<String>>() {}.getType());
    assertEquals(Arrays.asList("a", "b", "c"), abc);
  }
}
