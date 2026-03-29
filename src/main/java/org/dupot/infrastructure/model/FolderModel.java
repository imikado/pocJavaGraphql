package org.dupot.infrastructure.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.dupot.domain.entity.Folder;

public class FolderModel {

    // 1. Use Arrays.asList (plural) 
    // 2. Use double quotes " for Strings
    private List<Folder> folderList = Arrays.asList(
        new Folder(1, "my pics 2024", 1),
        new Folder(2, "my pics 2025", 1),
        new Folder(4, "my invoices 2024", 2),
        new Folder(5, "my invoices 2025", 2)
    );

    public List<Folder> getListByUserId(int userId) {
        // 3. Compare primitives with == (unless userId() returns an Integer object)
        // 4. .toList() returns a List directly; it doesn't need .orElse()
        return folderList.stream()
                .filter(folder -> folder.userId() == userId)
                .collect(Collectors.toList()); 
    }
}