package com.example.humo2.UtilOfb;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class OfbUtils {
    public static final String sql = "  select au.symbol_1 xxxflag,\n" +
            "                              au.symbol_9 account,\n" +
            "                              au.number_7 balance,\n" +
            "                              au.symbol_2 branch,\n" +
            "                              au.symbol_10 cardBelonging,\n" +
            "                              'DEBET' cardKind,\n" +
            "                              au.number_4 cardListVis,\n" +
            "                              au.symbol_4 cardNumberMask,\n" +
            "                              au.symbol_3 cardSort,\n" +
            "                              au.symbol_11 cardholderName,\n" +
            "                              au.symbol_12 currencyCode,\n" +
            "                              au.symbol_13 currencyIsoCode,\n" +
            "                              au.symbol_6 EMBOSSED_NAME,\n" +
            "                              to_date(au.symbol_5, 'dd.mm.yyyy') expirationDate,\n" +
            "                              au.symbol_17 extId,\n" +
            "                              au.number_5 rejection,\n" +
            "                              au.symbol_14 serviceTerms,\n" +
            "                              au.symbol_7 STATE,\n" +
            "                              au.number_6 tempBlocking,\n" +
            "                              au.symbol_14 type,\n" +
            "                              1 visibleAccount,\n" +
            "                              au.symbol_15 phoneNumber,\n" +
            "                              au.symbol_16 /*cardNumber*/,\n" +
            "                              au.number_2 xxxCLIENT_ID,\n" +
            "                              au.number_3 xxxCONTRACT_ID,\n" +
            "                              0 isAbroadUsing,\n" +
            "                              au.number_8 isInternetUsing,\n" +
            "                              1 replWOutConv,\n" +
            "                              1 withdWOutConv\n" +
            "                         from ibs.bss_au_reptemp_l au";
}
