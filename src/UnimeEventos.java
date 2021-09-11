/*
 * União Metropolitana de Educação e Cultura (UNIME)
 * Curso: Bacharelado em Sistemas de Informação
 * Disciplina: Programação Orientada a Objetos II
 * Professor: Pablo Ricardo Roxo Silva
 * Aluno: Paulo Reis dos Santos
 */

import Exceptions.GuestAlreadyExistsException;
import Exceptions.GuestNotFoundException;
import Services.EventManager;

import java.util.ArrayList;
import java.util.Scanner;

public class UnimeEventos {
    public static void main(String[] args) {

        EventManager eventManager = new EventManager();

        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("*=*=*=*=* Bem-vindo ao Gestor de Eventos da UNIME *=*=*=*=*");
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("*                  Selecione uma opção:                   *");
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("1 - Cadastrar participante");
        System.out.println("2 - Remover por posição");
        System.out.println("3 - Remover por nome");
        System.out.println("4 - Listar participantes");
        System.out.println("5 - Pesquisar participante");
        System.out.println("6 - Ordenar lista alfabeticamente");
        System.out.println("7 - Limpar lista");
        System.out.println("8 - Encerrar");

        Integer opcao = null;

        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("O que você deseja fazer? ");
                opcao = scanner.nextInt();

                if (opcao < 1 || opcao > 8) {
                    throw new Exception("Error!");
                }

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Informe o nome do participante:");
                        scanner = new Scanner(System.in);
                        eventManager.addGuest(scanner.nextLine());
                        System.out.println("Participante cadastrado com sucesso!");
                        opcao = null;
                    }
                    case 2 -> {
                        System.out.println("Informe o indice do participante a ser removido:");
                        scanner = new Scanner(System.in);
                        eventManager.removeGuestById(scanner.nextInt());
                        System.out.println("Participante removido com sucesso!");
                        opcao = null;
                    }
                    case 3 -> {
                        System.out.println("Informe o nome do participante a ser removido:");
                        scanner = new Scanner(System.in);
                        eventManager.removeGuestByName(scanner.nextLine());
                        System.out.println("Participante removido com sucesso!");
                        opcao = null;
                    }
                    case 4 -> {
                        System.out.println("Listando participantes:");
                        ArrayList<String> guests = eventManager.getAll();

                        if(guests.size() > 0) {
                            for (String guest : eventManager.getAll()) {
                                System.out.println("- " + guest);
                            }
                        } else {
                            System.out.println("Ainda não foi cadastrado nenhum participante!");
                        }

                        opcao = null;
                    }
                    case 5 -> {
                        System.out.println("Informe o nome do participante a ser pesquisado:");
                        scanner = new Scanner(System.in);
                        String guestName = scanner.nextLine();
                        System.out.println("Pesquisando participantes:");

                        if(eventManager.hasGuest(guestName)) {
                            System.out.println(guestName + " foi encontrado na lista de participantes!");
                        } else {
                            System.out.println(guestName + " não foi encontrado na lista de participantes!");
                        }

                        opcao = null;
                    }
                    case 6 -> {
                        System.out.println("A lista de participantes foi ordenada:");
                        eventManager.sort();
                        ArrayList<String> guests = eventManager.getAll();

                        if(guests.size() > 0) {
                            for (String guest : eventManager.getAll()) {
                                System.out.println("- " + guest);
                            }
                        } else {
                            System.out.println("Não foi possível ordernar a lista porque ainda não foi cadastrado nenhum participante!");
                        }

                        opcao = null;
                    }
                    case 7 -> {
                        eventManager.clear();
                        System.out.println("A lista de participantes está limpa!");

                        opcao = null;
                    }
                    case 8 -> {
                        System.out.println("Obrigado por utilizar o Unime Eventos. Até a próxima!!!");
                    }
                }
            } catch (GuestNotFoundException | GuestAlreadyExistsException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                opcao = null;
            } catch (Exception e) {
                System.out.println("Informe uma opção válida!");
                opcao = null;
            }
        }
        while (opcao == null);

    }
}
