/**
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.arquillian.graphene.ftest.wait;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author <a href="mailto:jpapouse@redhat.com">Jan Papousek</a>
 */
public class SearchContextLocatorElementTest extends AbstractWaitTest {

    protected static final By BY_CLASS_HEADER = By.className("header");
    protected static final By BY_CLASS_OPTION1 = By.className("option1");
    protected static final By BY_CLASS_SELECT = By.className("select");
    protected static final By BY_CLASS_TEXT_INPUT = By.className("textInput");
    protected static final By BY_CLASS_INPUT_WITH_EMPTY_STYLE = By.className("inputWithEmptyStyle");
    protected static final By BY_CLASS_INPUT_WITH_EMPTY_STYLE_WHITE_SPACES = By.className("inputWithEmptyStyleWhiteSpaces");
    protected static final By BY_CLASS_INPUT_WITH_NO_STYLE_DEFINED = By.className("inputWithNoStyleDefined");
    protected static final By BY_CLASS_INPUT_WITH_EMPTY_READONLY = By.className("inputWithEmptyReadonly");

    @FindBy(id="correct")
    private WebElement correct;

    @Test
    public void textElementIsPresent() {
        checkElementIsPresent(Graphene.waitModel().until().element(correct, BY_CLASS_HEADER));
    }

    @Test
    public void testElementIsSelected() {
        checkElementIsSelected(Graphene.waitModel().until().element(correct, BY_CLASS_OPTION1));
    }

    @Test
    public void testElementIsVisible() {
        checkElementIsVisible(Graphene.waitModel().until().element(correct, BY_CLASS_HEADER));
    }

    @Test
    public void testElementIsVisibleDirectly() {
        hideButton.click();
        Graphene.waitModel().until().element(correct, BY_CLASS_HEADER).is().not().visible();
        appearButton.click();
        Graphene.waitModel().until().element(correct, BY_CLASS_HEADER).is().visible();
    }

    @Test
    public void testElementTextContains() {
        checkElementTextContains(Graphene.waitModel().until().element(correct, BY_CLASS_HEADER));
    }

    @Test
    public void testElementTextEquals() {
        checkElementTextEquals(Graphene.waitModel().until().element(correct, BY_CLASS_HEADER));
    }

    @Test
    public void testElementIsEnabled() {
        checkElementIsEnabled(Graphene.waitModel().until().element(correct, BY_CLASS_SELECT));
    }

}
