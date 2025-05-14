package com.fxdrop.fxdropapi.enums.user;

public enum UserType {

    /** Administrador master da plataforma FXDROP */
    fxAdmin,

    /** Colaborador administrativo FXDROP */
    fxAdminColab,

    /** Suporte técnico da FXDROP */
    fxAdminSupport,

    /** Empresas clientes da FXDROP */
    fxAdminCompany,

    /** Colaborador de uma empresa cliente */
    fxColabCompany,

    /** Conta de serviços empresa cliente, exemplo: pdv onde vai aparecer as vendas e imprimir as etiquetas para empacotamento */
    fxServiceCompany
}
