/*
 * Copyright 2010 Ronnie Kolehmainen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.cssxfire;

import org.jetbrains.annotations.NotNull;

import java.io.CharArrayWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Ronnie
 */
public class StringUtils
{
    public static boolean equalsNormalizeWhitespace(@NotNull String s1, @NotNull String s2)
    {
        return normalizeWhitespace(s1).equals(normalizeWhitespace(s2));
    }

    @NotNull
    public static String normalizeWhitespace(@NotNull String s)
    {
        CharArrayWriter writer = new CharArrayWriter(s.length());
        char lastWritten = 'a';
        for (char c : s.trim().toCharArray())
        {
            if (Character.isWhitespace(c))
            {
                if (Character.isWhitespace(lastWritten))
                {
                    continue;
                }
                lastWritten = ' ';
                writer.append(lastWritten);
            }
            else
            {
                lastWritten = c;
                writer.append(lastWritten);
            }
        }
        return writer.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(normalizeWhitespace(" "));
        System.out.println(normalizeWhitespace("a,a:link"));
        System.out.println(normalizeWhitespace("  a,a:link"));
        System.out.println(normalizeWhitespace("  a,a:link  "));
        System.out.println(normalizeWhitespace("a, a:link"));
        System.out.println(normalizeWhitespace("a,  a:link"));
        System.out.println(normalizeWhitespace(" a,  a:link  "));
        System.out.println(normalizeWhitespace(" a,\na:link  "));
        System.out.println(normalizeWhitespace(" a,\n  a:link  "));
    }
}
