<p align="center">
  <img src="https://media.discordapp.net/attachments/1263566516134088864/1264443211196403762/LifeDexBannerNBG.png?ex=669de401&is=669c9281&hm=e294b9c49bae8308fb973015cf12a691680837bfd973d5d949e3be76441ee1e4&=&format=webp&quality=lossless&width=1440&height=345" width="500px" alt="Mem0 Logo">
</p>

# LifeDex: A Guidebook on Life
LifeDex is a website intended to help people who are new to living by themselves with useful guides on various amounts of topics.

# Quick Start
In order to build the program, you should have Gradle installed in an IDE of your choice.
```bash
# Ensure that you're in the folder that has the "gradlew" file installed.
./gradlew bootRun
```

Following this, the website should be up on `localhost:8080`.

about **easy recipes**, **"How to" tutorials**, **tips and tricks**, and advice on **financial decisions**.

# Features
- **"How To" Tutorials:** A large index of tutorials on how to do basic things, for example, "How to fold your laundry" or "How to cook food".
- **Easy Recipes:** A collection of easy recipes that would be easy for people to make.
- **Tips & Tricks:** A variety of "Tips & Tricks" that aren't important but would be nice to know.
- **Financial Advice:** A collection of financial advice for people living alone to manage their finances.

# Adding Changes
Updating the backend is fairly easy due to the usage of SpringBoot, every item, such as services and controllers are stored in their respective packages: controller, model, repository, and service.

Updating the frontend is also easy as you can navigate to this folder: `src\main\resources`. You can add templates under the "template" folder (e.x. post.html) and normal pages under the "static" folder (e.x. index.html).

# Roadmap
There are a variety of planned features for the future, as of 7/20/2024, the core features are yet to be created.