export class User {
  id?: number;
  name = '';
  email = '';
  password = '';
  birthDate = '';
  gender = '';
  active = true;

  static toJson(user: User): any {
    return {
      name: user.name,
      email: user.email,
      password: user.password,
      birthDate: User.formatDate(user.birthDate),
      gender: user.gender,
      active: user.active
    };
  }

  // converte "2002-09-26" (input date) em "26/09/2002" (formato da API)
  private static formatDate(date: string): string | null {
    if (!date) {
      return null;
    }
    return date.split('-').reverse().join('/');
  }
}