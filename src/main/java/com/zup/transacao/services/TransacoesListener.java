package com.zup.transacao.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.zup.transacao.model.transacoes.response.TransacoesResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacoesListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransacoesListener.class);

    @PersistenceContext
    private EntityManager manager;

    @KafkaListener(topics = "transacoes")
    @Transactional
    public void transacoesListenGroup(TransacoesResponse message) {
        LOGGER.info(message.toString());

        manager.merge(message.toEntity(manager));
    }
}
