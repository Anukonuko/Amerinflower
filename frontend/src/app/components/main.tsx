import styles from "src/app/styles/main.module.css"
import React from "react"

type MainProps = {
  children:React.ReactNode;
}

export default function Main({children}:MainProps){
  return (
    <>
      <main className={styles.mainWrapper}>
      {children}
      </main>
    </>

  )
}