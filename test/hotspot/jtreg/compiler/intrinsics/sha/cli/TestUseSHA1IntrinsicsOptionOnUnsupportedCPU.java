/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * @test
 * @bug 8035968
 * @summary Verify UseSHA1Intrinsics option processing on unsupported CPU.
 * @library /test/lib testcases /
 * @modules java.base/jdk.internal.misc
 *          java.management
 *
 * @build sun.hotspot.WhiteBox
 * @run driver ClassFileInstaller sun.hotspot.WhiteBox
 *                                sun.hotspot.WhiteBox$WhiteBoxPermission
 * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions
 *                   -XX:+WhiteBoxAPI
 *                   compiler.intrinsics.sha.cli.TestUseSHA1IntrinsicsOptionOnUnsupportedCPU
 */

package compiler.intrinsics.sha.cli;

import compiler.intrinsics.sha.cli.testcases.GenericTestCaseForOtherCPU;
import compiler.intrinsics.sha.cli.testcases.GenericTestCaseForUnsupportedAArch64CPU;
import compiler.intrinsics.sha.cli.testcases.GenericTestCaseForUnsupportedRiscv64CPU;
import compiler.intrinsics.sha.cli.testcases.GenericTestCaseForUnsupportedSparcCPU;
import compiler.intrinsics.sha.cli.testcases.GenericTestCaseForUnsupportedX86CPU;
import compiler.intrinsics.sha.cli.testcases.UseSHAIntrinsicsSpecificTestCaseForUnsupportedCPU;

public class TestUseSHA1IntrinsicsOptionOnUnsupportedCPU {
    public static void main(String args[]) throws Throwable {
        new SHAOptionsBase(
                new GenericTestCaseForUnsupportedSparcCPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION),
                new GenericTestCaseForUnsupportedX86CPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION),
                new GenericTestCaseForUnsupportedAArch64CPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION),
                new GenericTestCaseForUnsupportedRiscv64CPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION),
                new UseSHAIntrinsicsSpecificTestCaseForUnsupportedCPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION),
                new GenericTestCaseForOtherCPU(
                        SHAOptionsBase.USE_SHA1_INTRINSICS_OPTION)).test();
    }
}
