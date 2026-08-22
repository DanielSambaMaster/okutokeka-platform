package oku.Plataform.Security.Model.DataTransferObjects;

import java.util.UUID;

public record RegisterDTO(
        String login,
        String username,
        String emailAddress,
        String phoneNumber,
        String password,
        long teamId
) {
}