package com.guiving.web.dto.user;

import com.guiving.domain.user.User;
import com.guiving.vo.Name;
import com.guiving.vo.Picture;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@ToString
public class UserResponseDto {
    private Long id;
    private Name name;
    private String email;
    private Picture picture;
    private Set<CardResponseDto> cards;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.cards = user.getCardSet().stream()
                .map(CardResponseDto::new)
                .collect(Collectors.toSet());
    }
}
