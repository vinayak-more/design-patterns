package com.example.main;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.StatusCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class MainClass {

	public static void main(String[] args) {
		final String gitDir = "E:/GitRepository/design-patterns/.git";

		try {
			Repository repo = new FileRepositoryBuilder().setGitDir(
					new File(gitDir)).build();
			Git git = new Git(repo);
			PullResult call = git.pull().call();
			System.out.println(call.isSuccessful());
			if (call.isSuccessful()) {
				StatusCommand status = git.status();
				Set<String> untracked = status.call().getUntracked();
				System.out.println(untracked);
				for (String u : untracked) {
					git.add().addFilepattern(u).call();
				}
				git.commit().setMessage("JGIT " + new Date()).call();
			}else{
				System.out.println("Pull Failed");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoWorkTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
