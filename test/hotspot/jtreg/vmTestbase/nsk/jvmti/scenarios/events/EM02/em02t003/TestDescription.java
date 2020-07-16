/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


/*
 * @test
 *
 * @summary converted from VM Testbase nsk/jvmti/scenarios/events/EM02/em02t003.
 * VM Testbase keywords: [jpda, jvmti, noras, nonconcurrent]
 * VM Testbase readme:
 * DESCRIPTION
 *     This JVMTI test is for EM02 scenario of "events and event management" area.
 *     Test executes the following several steps for events COMPILED_METHOD_LOAD,
 *     COMPILED_METHOD_UNLOAD:
 *       1)
 *         - adds the <can_generate_compiled_method_load_events> capability in
 *           the OnLoad phase
 *         - sets callbacks for VM_INIT and choosen events during the OnLoad phase
 *         - enables events via SetEventNotificationMode during the OnLoad phase
 *           for all optional events.
 *         - provides the state to provoke generation of choosen events
 *         - checks that VM_INIT and choosen events were sent
 *       2)
 *         - changes callbacks for choosen events
 *         - provides the state to provoke generation of choosen events
 *         - checks that choosen events were sent
 *         - checks that altered callback works.
 *       3)
 *         - sets off callbacks for choosen events
 *         - sets callback for VM_DEATH event
 *         - checks that no choosen events are sent until VMDeath event.
 * COMMENTS
 *     #4033759 JIT compiler must support unloading of classes containing compiled methods
 *     Adjusted according to J2SE CCC updates:
 *     #4989580: JVMTI: Add JVMTI_ERROR_MUST_POSSESS_CAPABILITY to
 *               SetEventNotificationMode
 *     #5003914: JVMTI Spec: CompiledMethodUnload should specify that method is
 *               for identific
 *     Modified due to fix of the bug
 *     5010571 TEST_BUG: jvmti tests with VMObjectAlloc callbacks should
 *             be adjusted to new spec
 *     Fixed 5028164 bug.
 *     Fixed
 *     #5045048 TEST_BUG: jvmti tests should synchronize access to static vars
 *     Modified due to fix of rfe:
 *     #5055417 TEST: warnings and notes caused by generification
 *
 * @library /vmTestbase
 *          /test/lib
 * @run driver jdk.test.lib.FileInstaller . .
 * @build nsk.jvmti.scenarios.events.EM02.em02t003
 *
 * @comment compile loadclassXX to bin/loadclassXX
 * @run driver nsk.share.ExtraClassesBuilder
 *      loadclass
 *
 * @run main/othervm/native
 *      -agentlib:em02t003=-waittime=5
 *      -XX:-UseGCOverheadLimit
 *      nsk.jvmti.scenarios.events.EM02.em02t003
 *      ./bin/loadclass
 */

