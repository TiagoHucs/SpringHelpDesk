export class User {
    constructor(public id: string,
        public email: string,
        public password: string,
        public profile: string) {
    }
}

export class PerfilVO {
    id: string;
    nome: string;
    imagem: string;
}


export class CurrentUser {
    public token: string;
    public user: User;
}
