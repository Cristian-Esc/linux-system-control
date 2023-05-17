package com.esserdi.linux.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.io.BufferedReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/control")
public class LinuxController {

	@GetMapping("/")
	public String homePage(Model model) {
		return "index";
	}

	@GetMapping("/sceen-lock")
	public String openFirefox(Model model) throws IOException {
		String message = "";
		try {
			Runtime.getRuntime().exec("xdg-screensaver lock");
			message = "Comando ejecutado con éxito";
		} catch (IOException e) {
			message = "Error al ejecutar el comando";
		}
		model.addAttribute("message", message);
		return "redirect:/control/";
	}
	
	
	@GetMapping("/takePhoto")
	public String takePhoto(Model model) throws IOException {
		String pattern = "yyyyMMdd_HHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateAndTime = formatter.format(new Date());
		String imagePath = System.getProperty("user.home") + "/.control-pc-esserdi/image_" + dateAndTime +".jpg";
        String command = "fswebcam -r 1280x720 --jpeg 100 -D 1 -S 50 " + imagePath;
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("The command has finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		return "redirect:/control/";
	}
	
	
	
	@GetMapping("/takeScreenshot")
	public String takeScreenshot(Model model) throws IOException {
		String pattern = "yyyyMMdd_HHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateAndTime = formatter.format(new Date());
        String imagePath = System.getProperty("user.home") + "/.control-pc-esserdi/screenshot_" + dateAndTime + ".png";
        String command = "gnome-screenshot -f " + imagePath;
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("The command has finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
		return "redirect:/control/";
	}
	
	
	
	@GetMapping("/adjustVolume")
	public String adjustVolume(Model model) throws IOException {
		String command = "amixer sset Master 0%";
		
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			 e.printStackTrace();
		}
    
		return "redirect:/control/";
	}
	
	

}
