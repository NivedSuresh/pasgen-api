package org.personal.app.common.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PagedDto <T>
{
    private List<T> dtos;
    private boolean hasNext;
    private boolean hasPrev;
    private int totalPages;
    private int currentPage;
}
