package project.myblog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Message {
    private String id;
    private String content;
    private String sender;
}