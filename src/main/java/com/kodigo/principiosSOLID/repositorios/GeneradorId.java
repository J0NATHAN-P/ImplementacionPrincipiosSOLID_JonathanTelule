package com.kodigo.principiosSOLID.repositorios;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generador de IDs numéricos incrementales (1,2,3,...).
 */
public class GeneradorId {
    private final AtomicInteger contador = new AtomicInteger(0);

    public String siguiente() {
        return String.valueOf(contador.incrementAndGet());
    }
}
