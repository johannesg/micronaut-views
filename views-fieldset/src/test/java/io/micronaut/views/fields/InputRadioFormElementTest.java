package io.micronaut.views.fields;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.views.fields.elements.InputRadioFormElement;
import io.micronaut.views.fields.elements.Radio;
import io.micronaut.views.fields.messages.Message;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputRadioFormElementTest {
    @Test
    void testTagAndType() {
        InputRadioFormElement formElement = InputRadioFormElement.builder().build();
        assertEquals(HtmlTag.INPUT, formElement.getTag());
        assertEquals(InputType.RADIO, formElement.getType());
    }

    @Test
    void inputRadioFormElementHasaBuilderApi() {
        String name = "drone";
        String value = "value";
        String id = "id";
        Message label = Message.of( "Huey", "drone.huey");
        Radio radio = Radio.builder()
            .value(value)
            .id(id)
            .label(label)
            .build();
        List<Radio> buttons = Collections.singletonList(radio);
        InputRadioFormElement input = InputRadioFormElement.builder().name(name).buttons(buttons).build();
        assertEquals(name, input.name());
        assertEquals(id, input.buttons().get(0).getId());
        assertEquals(label, input.buttons().get(0).getLabel());
        assertEquals(value, input.buttons().get(0).getValue());

        BeanIntrospection<InputRadioFormElement> introspection = BeanIntrospection.getIntrospection(InputRadioFormElement.class);
        BeanIntrospection.Builder<InputRadioFormElement> builder = introspection.builder();
        input = builder
            .with("name", name)
            .with("buttons", buttons)
            .build();

        assertEquals(name, input.name());
        assertEquals(id, input.buttons().get(0).getId());
        assertEquals(label, input.buttons().get(0).getLabel());
        assertEquals(value, input.buttons().get(0).getValue());
    }
}
