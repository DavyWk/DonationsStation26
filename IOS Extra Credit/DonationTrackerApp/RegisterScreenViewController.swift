//
//  RegisterScreenViewController.swift
//  Donation Tracker
//
//  Created by Angelik Laboy Torres on 11/27/18.
//  Copyright © 2018 Angelik Laboy Torres. All rights reserved.
//
import UIKit
import Firebase

class RegisterViewController: UIViewController {
    var refType: DatabaseReference!
    @IBOutlet weak var registerButton: UIButton!
    @IBOutlet weak var emailTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var typeTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        refType = Database.database().reference().child("type");
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func registerButtonPressed(_ sender: Any) {
        addType();
        Auth.auth().createUser(withEmail: emailTextField.text!, password: passwordTextField.text!) { (user, error) in
            if (error != nil){
                let myAlert = UIAlertController(title: "Alert", message: error?.localizedDescription, preferredStyle: .alert)
                let okAction = UIAlertAction(title: "Ok", style: .default, handler: nil)
                myAlert.addAction(okAction)
                self.present(myAlert, animated: true, completion: nil)
                
                return
            }else{
                self.performSegue(withIdentifier: "goToLogin", sender: self)
            }
        }
    }
    func addType(){
        let key = refType.childByAutoId().key
        
        let type = ["id":key,
                      "username": emailTextField.text! as String,
                      "password": passwordTextField.text! as String,
                      "user Type": typeTextField.text! as String
                    ]
        refType.child(key!).setValue(type)
    }
}
