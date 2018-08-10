package io.github.yoannfleurydev.hateoasspringboot.contact;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ContactAssembler extends ResourceAssemblerSupport<Contact, ContactResource> {

    ContactAssembler() {
        super(ContactController.class, ContactResource.class);
    }

    public Contact toEntity(ContactResource contactResource) {

        return Contact.builder()
                .firstName(contactResource.getFirstName())
                .lastName(contactResource.getLastName())
                .build();
    }

    @Override
    public ContactResource toResource(Contact contact) {
        return createResourceWithId(contact.getId(), contact);
    }

    @Override
    protected ContactResource instantiateResource(Contact entity) {
        ContactResource contactResource = super.instantiateResource(entity);

        contactResource.setFirstName(entity.getFirstName());
        contactResource.setLastName(entity.getLastName());
        contactResource.setResourceId(entity.getId());

        return contactResource;
    }
}
