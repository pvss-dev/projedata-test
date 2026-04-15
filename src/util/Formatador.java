package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Utilitário para formatação de dados.
 */
public class Formatador {

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final NumberFormat FORMATO_MOEDA = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

    static {
        FORMATO_MOEDA.setMinimumFractionDigits(2);
        FORMATO_MOEDA.setMaximumFractionDigits(2);
    }

    private Formatador() {}

    /**
     * Formata uma data no padrão dd/MM/yyyy.
     */
    public static String formatarData(LocalDate data) {
        return data.format(FORMATO_DATA);
    }

    /**
     * Formata um BigDecimal no padrão brasileiro.
     */
    public static String formatarSalario(BigDecimal valor) {
        return FORMATO_MOEDA.format(valor);
    }

    /**
     * Formata um BigDecimal como quantidade de salários mínimos.
     */
    public static String formatarQuantidade(BigDecimal valor) {
        return valor.toString().replace(".", ",");
    }
}