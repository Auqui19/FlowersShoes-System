export interface LoginResponse{
    code: string;
    error: string;
    token : string;
}

export interface Trabajador{
    idtra: number;
    nombres: string;
    tipodocumento: string;
    nrodocumento: string;
    direccion: string;
    rol: string;
    email : string;
    password : string;
    estado : string;
}