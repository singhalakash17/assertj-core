/*
 * Created on Oct 19, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.assertj.core.assertions.internal;

import static org.assertj.core.assertions.test.ExpectedException.none;

import static org.mockito.Mockito.spy;

import java.util.Comparator;

import org.assertj.core.assertions.internal.Comparables;
import org.assertj.core.assertions.internal.ComparatorBasedComparisonStrategy;
import org.assertj.core.assertions.internal.Failures;
import org.assertj.core.assertions.internal.StandardComparisonStrategy;
import org.assertj.core.assertions.test.ExpectedException;
import org.assertj.core.assertions.util.AbsValueComparator;
import org.junit.Before;
import org.junit.Rule;


/**
 * Base class for testing <code>{@link Comparables}</code>, set up an instance with {@link StandardComparisonStrategy} and another
 * with {@link ComparatorBasedComparisonStrategy}.
 * <p>
 * Is in <code>org.fest.assertions.internal</code> package to be able to set {@link Comparables#failures} appropriately.
 * 
 * @author Joel Costigliola
 */
public class ComparablesBaseTest {

  @Rule
  public ExpectedException thrown = none();

  protected Failures failures;
  protected Comparables comparables;

  protected ComparatorBasedComparisonStrategy customComparisonStrategy;
  protected Comparables comparablesWithCustomComparisonStrategy;

  public ComparablesBaseTest() {
    super();
  }

  @Before
  public void setUp() {
    failures = spy(new Failures());
    comparables = new Comparables();
    comparables.failures = failures;
    customComparisonStrategy = new ComparatorBasedComparisonStrategy(comparatorForCustomComparisonStrategy());
    comparablesWithCustomComparisonStrategy = new Comparables(customComparisonStrategy);
    comparablesWithCustomComparisonStrategy.failures = failures;
  }

  protected Comparator<?> comparatorForCustomComparisonStrategy() {
    return new AbsValueComparator<Integer>();
  }

}