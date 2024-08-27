package com.eventos.eventos.services.crud;

import javax.swing.text.html.parser.Entity;

public interface LeerPorId<Entity, ID> {

    public Entity readById(ID id);
}
