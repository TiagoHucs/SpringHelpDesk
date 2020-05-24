
export class ChamadoEditarResource {
    chamadoVO: ChamadoVO;
    statusList: any[];

}


export class ChamadoVO {
    id: string;
    dataHoraAbertura: number;
    dataHoraFechamento: any;
    statusId: string;
    status: StatusChamadoVO;
    titulo: string;
    descricao: string;
}

export class StatusChamadoVO {
    codigo: string;
    descricao: string;
}
