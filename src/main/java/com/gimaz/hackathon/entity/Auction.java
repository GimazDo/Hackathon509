package com.gimaz.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_auc")
    private LocalDateTime startAuc;

    @Column(name = "end_auc")
    private  LocalDateTime endAuc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lot_id")
    private Lot lot;

    private Double Price;

    private boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "auction_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "auction_id"))
    private Collection<User> users;

}
