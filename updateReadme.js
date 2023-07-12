const fs = require("fs");
const path = require("path");

const getProblemNames = (week) => {
  try {
    const p = path.join("Level1", week, "README.md");
    const content = fs.readFileSync(p, "utf-8");
    const lines = content.split("\n");
    const names = [];

    lines.map((line) => {
      if (line.startsWith(names.length + 1 + ". ")) {
        const name = line.replace(names.length + 1 + ". ", "");
        names.push(name);
      }
    });

    return names;
  } catch (err) {
    return [];
  }
};

const updateReadme = () => {
  const folders = fs.readdirSync("Level1");
  const problems = [];
  let totalCount = 0;

  folders.sort().map((folder) => {
    if (folder.startsWith("week")) {
      const names = getProblemNames(folder);
      problems.push({ [folder]: names });
      totalCount += names.length;
    }
  });

  console.log("총 문제 수 : ", totalCount);

  const p = "README.md";
  const content = fs.readFileSync(p, "utf-8");
  let lines = content.split("\n");
  const duplicates = [];

  problems.reduce((a, c, i) => {
    try {
      const key = Object.keys(c)[0];
      const names = c[key];
      const header = "### " + key;

      if (lines.includes(header)) {
        let index = lines.indexOf(header) + 1;
        lines = lines.slice(0, index);
        for (let name of names) {
          lines.push("- " + name);
        }
      } else {
        lines.push(header);
        lines.push("");
        for (let name of names) {
          if (a.some((v) => v === name)) {
            lines.push("- (중복) " + name);
            duplicates.push(key + " : " + name);
          } else {
            lines.push("- " + name);
          }
        }
      }
      lines.push("");
      return [...a, ...names];
    } catch (err) {
      return a;
    }
  }, []);

  if (duplicates.length > 0) {
    console.log("\n중복된 문제!!!");
    for (let name of duplicates) {
      console.log("- " + name);
    }
  }

  const newContent = lines.join("\n");
  fs.writeFileSync(p, newContent, "utf-8");
};

updateReadme();
