package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Cria uma instância do DepartmentDao
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        // Busca o departamento com ID = 2
        Department dep = departmentDao.findById(2);
        System.out.println("Departamento encontrado: " + dep);

        // Lista todos os departamentos
        System.out.println("\nLista de todos os departamentos:");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        // Insere um novo departamento
        Department dep2 = new Department("Estofados");
        departmentDao.insert(dep2);
        System.out.println("Inserido com sucesso! Novo ID = " + dep2.getId());

        // Deleta um departamento pelo ID informado
        System.out.print("Digite o ID do departamento a ser deletado: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Exclusão concluída.");

        // Atualiza o nome de um departamento existente
        dep = departmentDao.findById(6);
        dep.setName("Imoveis");
        departmentDao.update(dep);
        System.out.println("Atualização concluída.");

        sc.close();
    }
}

