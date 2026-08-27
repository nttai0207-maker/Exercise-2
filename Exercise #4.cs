using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercise__4
{
        public class BankAccount
        {
            // Private backing fields
            private decimal _balance;
            private string _pin;
            private int _failedAttempts;

            // Public read-only property (set via constructor only)
            public string AccountHolder { get; }

            // Public getter, private set. True if _failedAttempts >= 3
            public bool IsLocked { get; private set; }

            // Constructor
            public BankAccount(string accountHolder, decimal initialBalance, string initialPin)
            {
                AccountHolder = accountHolder;
                _balance = initialBalance > 0 ? initialBalance : 0;
                _pin = initialPin;
                _failedAttempts = 0;
                IsLocked = false;
            }

            public bool Deposit(decimal amount)
            {
                if (amount <= 0)
                {
                    Console.WriteLine("Error: Deposit amount must be positive.");
                    return false;
                }

                _balance += amount;
                Console.WriteLine($"Successfully deposited {amount:C}.");
                return true;
            }

            public bool Withdraw(decimal amount, string inputPin)
            {
                if (IsLocked)
                {
                    Console.WriteLine("Error: Account is locked due to multiple failed PIN attempts.");
                    return false;
                }

                if (inputPin != _pin)
                {
                    _failedAttempts++;
                    if (_failedAttempts >= 3)
                    {
                        IsLocked = true;
                        Console.WriteLine("Error: Invalid PIN code. Account has been LOCKED for security!");
                    }
                    else
                    {
                        Console.WriteLine($"Error: Invalid PIN code. (Attempt {_failedAttempts}/3)");
                    }
                    return false;
                }

                _failedAttempts = 0;

                if (amount <= 0)
                {
                    Console.WriteLine("Error: Withdrawal amount must be positive.");
                    return false;
                }

                if (_balance < amount)
                {
                    Console.WriteLine("Error: Insufficient funds.");
                    return false;
                }

                _balance -= amount;
                return true;
            }

            public decimal GetBalance(string inputPin)
            {
                if (inputPin != _pin)
                {
                    Console.WriteLine("Error: Invalid PIN code.");
                    return -1m;
                }

                return _balance;
            }

            public bool ChangePin(string currentPin, string newPin)
            {
                if (currentPin != _pin)
                {
                    Console.WriteLine("Error: Invalid current PIN.");
                    return false;
                }

                if (string.IsNullOrEmpty(newPin) || newPin.Length != 4 || !newPin.All(char.IsDigit))
                {
                    Console.WriteLine("Error: New PIN must be exactly 4 numeric characters.");
                    return false;
                }

                _pin = newPin;
                return true;
            }
        }

        class Program
        {
            static void Main(string[] args)
            {
                BankAccount account = new BankAccount("John Doe", 500.00m, "1234");
                Console.WriteLine($"Account Holder: {account.AccountHolder}");

                Console.WriteLine("\n--- 1. Testing Deposit ---");
                account.Deposit(-50m);
                account.Deposit(200m);

                Console.WriteLine("\n--- 2. Testing Protected Balance View ---");
                account.GetBalance("9999");
                decimal currentBalance = account.GetBalance("1234");
                Console.WriteLine($"Verified Balance: {currentBalance:C}");

                Console.WriteLine("\n--- 3. Testing Lockout Mechanism ---");
                account.Withdraw(100m, "0000");
                account.Withdraw(100m, "1111");
                account.Withdraw(100m, "2222");
                account.Withdraw(100m, "1234");

            Console.WriteLine("\n--- 4. Account Lock Status ---");
                Console.WriteLine($"Is account locked? {account.IsLocked}");
            }
        }
    }


