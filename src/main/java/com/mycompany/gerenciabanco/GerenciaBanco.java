/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author igaro
 */
public class GerenciaBanco {

    static class Cliente {
        String nome;
        String sobrenome;
        String cpf;
        double saldo;

        public Cliente(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        // Aqui tem as funções para consultar, depositar e retirar o dinheiro
        public void consultarSaldo() {
            System.out.println("Saldo atual: R$ " + saldo);
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor de depósito inválido.");
            }
        }

        public void retirar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.println("Retirada de R$ " + valor + " realizada com sucesso.");
            } else {
                System.out.println("Valor de retirada inválido ou saldo insuficiente.");
            }
        }
    }

    // Método para exibição do menu, e ficar em loop até finalizar a escolha
    public static void exibirMenu(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depósito");
            System.out.println("3 - Retirada");
            System.out.println("4 - Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();
                    cliente.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor da retirada: ");
                    double retirada = scanner.nextDouble();
                    cliente.retirar(retirada);
                    break;
                case 4:
                    System.out.println("Saindo... Obrigado por usar nosso sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    // Método inicail, para cadstro de um novo cliente
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados pessoais
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        // Criação do novo objeto Cliente
        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        exibirMenu(cliente);
    }
}
