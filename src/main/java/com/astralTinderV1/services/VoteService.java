package com.astralTinderV1.services;

import com.astralTinderV1.enttities.User;
import com.astralTinderV1.enttities.Vote;
import com.astralTinderV1.repositories.VoteRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private VoteRepository voteRepository;
    private UserService userService;

    @Autowired
    public VoteService(VoteRepository voteRepository, UserService userService) {
        this.voteRepository = voteRepository;
        this.userService = userService;
    }

    @Transactional
    public void saveVote(Vote vote) {
        System.out.println(vote);
        User user1 = vote.getUserRecive();
        User user2 = vote.getUserSend();

        //guarda el usuario que envio el voto en los recibidos del receptor
        //guarda el usuario que recibe el voto en los enviados del emisor
        List<User> likesReciveUser1 = user1.getLikeReceived();
        likesReciveUser1.add(user2);
        List<User> likesSendUser2 = user2.getLikeSent();
        likesSendUser2.add(user1);

        //Seteo las listas como las listas pertenecientes a los User
        user1.setLikeReceived(likesReciveUser1);
        user2.setLikeSent(likesSendUser2);

        voteRepository.save(vote);
    }

    @Transactional
    public boolean Match(Vote vote) {

        User user1 = vote.getUserRecive();
        User user2 = vote.getUserSend();

        //extraigo los id de los dos usuarios
        String idUser1 = user1.getId();
        String idUser2 = user2.getId();

        //Recorro la lista e likes recividos de los dos usuarios 
        //buscando si se encutra(true/false) el id del otro user
        Boolean match1 = user1.getLikeReceived().stream().anyMatch(user -> user.getId().equals(idUser2));
        Boolean match2 = user2.getLikeReceived().stream().anyMatch(user -> user.getId().equals(idUser1));

        //Si los dos usuarios paracen en sus listas de recividos 
        //se guardan los usuarios en la lista de matches de cada uno
        if (match1 == true && match2 == true) {

            List<User> matchsUser1 = user1.getMatches();
            matchsUser1.add(user2);
            List<User> matchsUser2 = user2.getMatches();
            matchsUser2.add(user1);

        }
        return (match1 && match2);
    }

}
