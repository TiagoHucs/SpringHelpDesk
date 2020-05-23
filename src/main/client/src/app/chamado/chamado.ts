
export class ChamadoEditarResource {
    chamadoVO: ChamadoVO;
    statusList: any[];

}


export class ChamadoVO {
    id: string;
    dataHoraAbertura: number;
    dataHoraFechamento: any;
    status: string;
    descricao: string;
}
