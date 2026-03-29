package org.dupot.graphql.infrastructure.graphql.query;

import org.springframework.graphql.data.method.annotation.ContextValue;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import org.dupot.domain.entity.Folder;
import org.dupot.infrastructure.model.FolderModel;



@Controller
class FolderQuery {

    @QueryMapping
    public List<Folder> getFolders(@ContextValue(required = false) Integer userId) {
        if (userId == null) {
            throw new RuntimeException("Unauthorized");
        }
        return new FolderModel().getListByUserId(userId);
    }

   

}